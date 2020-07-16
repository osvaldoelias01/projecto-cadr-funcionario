package controller;

import model.FuncionarioModel;
import repository.FuncionarioReposirtory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FuncionarioController", urlPatterns = {"/FuncionarioController"})
public class FuncionarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String HOME = "/index.jsp";
    private static String INSERT = "/cadastrar.jsp";
    private static String EDIT = "/editar.jsp";
    private static String LIST = "/listar.jsp";
    private static String DELETE = "/deletar.jsp";

    FuncionarioReposirtory reposirtory;
    FuncionarioModel funcionarioModel;
    private    String forward = "";
    public  FuncionarioController(){
        super();
        reposirtory = new FuncionarioReposirtory();
        funcionarioModel = new FuncionarioModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("deletar")){

            int funcionaroId = Integer.parseInt(request.getParameter("id"));
            reposirtory.deletarFuniconario(funcionaroId);
           request.setAttribute("funcionarioModel", reposirtory.listarTodosFuncionarios());
            forward = DELETE;
        }
        else if(action.equalsIgnoreCase("editar")){
            forward = EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            FuncionarioModel funcionarioModel = reposirtory.listarFuncionario(id);
            System.out.println("Madiê: " + funcionarioModel.getNome());
            request.setAttribute("funcionarioModel", funcionarioModel);
        }
        /**else if(action.equalsIgnoreCase("cadastrar")){
            System.out.println("Não pedi para Cadastrar");

            forward = INSERT;

        }**/
        else if (action.equalsIgnoreCase("listar")){
            System.out.println("Devia listar");
            List<FuncionarioModel> funcionarios = reposirtory.listarTodosFuncionarios();
            System.out.println("===================================================");
            for (int i = 0; i < funcionarios.size(); i++){
                System.out.println((i+1) + ": " + funcionarios.get(i).getNome());
            }
            System.out.println("===================================================");
            request.setAttribute("funcionarios", funcionarios);
            forward = LIST;
        }
        else{
            forward = HOME;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Chegou no do Post");

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");
        String cargo = request.getParameter("cargo");
        String salario = request.getParameter("salario");
        setString(id, nome, idade, cargo, salario);

        if (toInt(id) <= 0) {
            System.out.println("vai cadastrar");
            cadastrar(funcionarioModel);
            System.out.println("cadastrou");
        } else {
            System.out.println("vai editar");
            editar(funcionarioModel);
            System.out.println("cadastrou");
            response.sendRedirect("index.jsp");
        }
        response.sendRedirect("index.jsp");
    }


    private void editar(FuncionarioModel funcionarioModel) {
        reposirtory.editarFunionario(funcionarioModel);
    }





    private void cadastrar(FuncionarioModel funcionarioModel) {
        reposirtory.cadastrar(funcionarioModel);
    }
    private void setString(String id, String nome, String idade, String cargo, String salario) {
        try {
            int i = toInt(id);
            funcionarioModel.setId(i);
            funcionarioModel.setNome(nome);
            int ida = toInt(idade);
            funcionarioModel.setIdade(ida);
            funcionarioModel.setCargo(cargo);
            double sal = toDouble(salario.trim());
            funcionarioModel.setSalario(sal);
        } catch (Exception erro) {
            System.out.println("Erro em SetString: " + erro.getMessage());
        }
    }
    private int toInt(String valor) {
        try {
            return Integer.parseInt(valor);
        } catch (Exception e) {
            return 0;
        }
    }
    private double toDouble(String valor) {
        try {
            return Double.parseDouble(valor);
        } catch (Exception e) {
            return 0;
        }
    }
}