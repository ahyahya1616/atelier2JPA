package ma.fstt.firstjpa.web;

import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ma.fstt.firstjpa.entities.Internaute;
import ma.fstt.firstjpa.services.InternauteService;

import java.io.IOException;

@WebServlet("/internaute")
public class InternauteController extends HttpServlet {

    @Inject
    private InternauteService internauteService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "loginForm";

        switch (action) {
            case "registerForm":
                request.getRequestDispatcher("/WEB-INF/views/internaute/register.jsp").forward(request, response);
                break;

            case "logout":
                HttpSession session = request.getSession(false);
                if (session != null) session.invalidate();
                response.sendRedirect("internaute?action=loginForm");
                break;

            default:
                request.getRequestDispatcher("/WEB-INF/views/internaute/login.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {

            case "register": {
                String nom = request.getParameter("nom");
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                Internaute internaute = new Internaute();
                internaute.setNom(nom);
                internaute.setEmail(email);
                internaute.setPassword(password);

                internauteService.inscrire(internaute);
                response.sendRedirect("internaute?action=loginForm");
                break;
            }

            case "login": {
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                Internaute internaute = internauteService.connexion(email, password);

                if (internaute != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("internaute", internaute);
                    response.sendRedirect("produit?action=list");
                } else {
                    request.setAttribute("error", "Email ou mot de passe incorrect");
                    request.getRequestDispatcher("/WEB-INF/views/internaute/login.jsp").forward(request, response);
                }
                break;
            }
        }
    }
}
