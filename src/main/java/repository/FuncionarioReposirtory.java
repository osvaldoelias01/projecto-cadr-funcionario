package repository;

import model.FuncionarioModel;
import utlility.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FuncionarioReposirtory {

    private  List<FuncionarioModel> listFuncionarios = new ArrayList<FuncionarioModel>();

    private Connection conexao = new DataBase().conexao();
    private ResultSet resultSet = null;
   // private PreparedStatement statement = null;

    public FuncionarioReposirtory() {
    //    this.conexao = new DataBase().conexao();
      //  this.resultSet = null;


    }
    public void cadastrar(FuncionarioModel funcionarioModel) {
        String sql = ("INSERT INTO cad_funcionarios (Nome, Idade, Cargo, Salario)  VALUES (?, ?, ?, ?);");
        try {

            PreparedStatement statement = this.conexao.prepareStatement(sql);

            statement.setString(1,funcionarioModel.getNome() );

            statement.setInt(2, funcionarioModel.getIdade());

            statement.setString(3, funcionarioModel.getCargo());

            statement.setDouble(4, funcionarioModel.getSalario());

            statement.executeUpdate();
            statement.close();

        } catch (SQLException erro) {

            System.out.println("erro 1: " + erro);
        } catch (NullPointerException n) {
            System.out.println("erro 2: " + n);

        }
    }


    public List<FuncionarioModel> listarTodosFuncionarios(){
        String funcionario_query = "SELECT * FROM cad_funcionarios";
        List<FuncionarioModel> listFuncionarios = new ArrayList<FuncionarioModel>();

        try {
            PreparedStatement statement = this.conexao.prepareStatement(funcionario_query);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FuncionarioModel funcionarioModel = new FuncionarioModel();
                funcionarioModel.setId(resultSet.getInt("Id"));
                funcionarioModel.setNome(resultSet.getString("Nome"));
                funcionarioModel.setIdade(resultSet.getInt("Idade"));
                funcionarioModel.setCargo(resultSet.getString("Cargo"));
                funcionarioModel.setSalario(resultSet.getDouble("Salario"));
                listFuncionarios.add(funcionarioModel);
            }


        } catch (SQLException e) {
            System.out.println("tem erro: ");
            e.printStackTrace();
        }


        return listFuncionarios;
    }



    public FuncionarioModel listarFuncionario(int id){

        try {
            String sql = "SELECT * FROM cad_funcionarios WHERE Id = ?";
            PreparedStatement statement = this.conexao.prepareStatement(sql);
            statement.setInt(1, id);

            this.resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FuncionarioModel funcionarioModel = new FuncionarioModel();
                funcionarioModel.setId(resultSet.getInt("id"));
                funcionarioModel.setNome(resultSet.getString("nome"));
                funcionarioModel.setIdade(resultSet.getInt("idade"));
                funcionarioModel.setCargo(resultSet.getString("cargo"));
                funcionarioModel.setSalario(resultSet.getDouble("salario"));

                statement.close();

                return funcionarioModel;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public void editarFunionario(FuncionarioModel funcionarioModel) {

        String sql = "UPDATE cad_funcionarios SET Nome=?, Idade=?, Cargo=?, Salario=?" + " WHERE Id =? ";

        try {

            PreparedStatement statement = this.conexao.prepareStatement(sql);
            statement.setString(1, funcionarioModel.getNome());
            statement.setInt(2, funcionarioModel.getIdade());
            statement.setString(3, funcionarioModel.getCargo());
            statement.setDouble(4, funcionarioModel.getSalario());
            statement.setInt(5, funcionarioModel.getId());

            int teste = statement.executeUpdate();
            System.out.println(teste);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   /* public FuncionarioModel getFuncionarioById(String id) {
        try {

            String sql = ("SELECT  * FROM cad_funcionarios WHERE  id =? ");
            statement = this.conexao.conexao().prepareStatement(sql);
            this.resultSet = statement.executeQuery();

            while (resultSet.next()) {
                FuncionarioModel funcionarioModel = new FuncionarioModel();
                funcionarioModel.setId(resultSet.getInt("id"));
                funcionarioModel.setNome(resultSet.getString("nome"));
                funcionarioModel.setIdade(resultSet.getInt("idade"));
                funcionarioModel.setCargo(resultSet.getString("cargo"));
                funcionarioModel.setSalario(resultSet.getDouble("salario"));
                statement.close();
                return funcionarioModel;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    **/



    public FuncionarioModel deletarFuniconario(int id) {
        String sql = "DELETE FROM cad_funcionarios WHERE id = ?";

        try {
            PreparedStatement statement = this.conexao.prepareStatement(sql);
            statement.setInt(1, id);
            int teste = statement.executeUpdate();
            System.out.println(teste);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}



