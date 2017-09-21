package br.fiap.dao;

import br.fiap.conexao.Conexao;
import br.fiap.laboratorio.Laboratorio;
import br.fiap.ocorrencia.Ocorrencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author soonicz
 */
public class DAO {

    private Connection connection;
    private PreparedStatement p;
    private String sql;
    private ResultSet rs;

    //Insere um objeto Ocorrencia na tabela java_ocorrencia
    public boolean inserirOcorrencia(Ocorrencia ocorrencia) {
        sql = "insert into java_ocorrencia values(?, ?, ?, ?)";
        boolean conseguiu = false;
        connection = Conexao.getConnection();

        try {
            p = connection.prepareStatement(sql);
            p.setString(1, String.valueOf(ocorrencia.getChamado()));
            p.setString(2, ocorrencia.getLab());
            p.setString(3, String.valueOf(ocorrencia.getComp()));
            p.setString(4, ocorrencia.getProblema());
            p.execute();
            conseguiu = true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conseguiu;
    }

    /*
     *  Recebe laboratorio e a lista de laboratorios já existentes
     *  Insere um objeto Laboratorio na tabela java_laboratorio
     *  Registra na lista caso consiga cadastrar no banco de dados
     */
    public boolean inserirLaboratorio(Laboratorio laboratorio) {
        sql = "insert into java_laboratorio values(?, ?)";
        boolean conseguiu = false;
        connection = Conexao.getConnection();

        try {
            p = connection.prepareStatement(sql);
            p.setString(1, String.valueOf(laboratorio.getCodigo()));
            p.setString(2, laboratorio.getLab());
            p.execute();
            conseguiu = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar no banco !" + ex);
        }

        return conseguiu;
    }

    //Recebe o nº do chamado e pesquisa a Ocorrencia no banco de dados
    public Ocorrencia pesquisarOcorrencia(int chamado) {
        Ocorrencia aux = null;
        sql = "select * from java_ocorrencia where chamado= ?";
        connection = Conexao.getConnection();

        try {
            p = connection.prepareStatement(sql);
            p.setString(1, String.valueOf(chamado));
            rs = p.executeQuery();
            if (rs.next()) {
                String lab = rs.getString("laboratorio");
                String comp = rs.getString("computador");
                String problema = rs.getString("problema");
                aux = new Ocorrencia(chamado, lab, comp, problema);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }

    //Pesquisa todos os laboratorios cadastrados e retorna uma lista com eles
    public ArrayList<Laboratorio> pesquisarLaboratorio() {
        sql = "select * from java_laboratorio";
        ArrayList<Laboratorio> auxList = new ArrayList();
        connection = Conexao.getConnection();

        try {
            p = connection.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                int codigo = Integer.parseInt(rs.getString("codigo"));
                String lab = rs.getString("laboratorio");
                Laboratorio aux = new Laboratorio(codigo, lab);
                auxList.add(aux);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao pesquisar no banco!!" + ex);
        }
        return auxList;
    }
}
