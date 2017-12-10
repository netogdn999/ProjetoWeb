package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.LanceBean;

public class LanceDAO { //int id, int idFornecedor, float total, int qtdParcelas,
	//int prazoEntrega, float[] lances, Date dataLance, boolean isForaDoPadrao
	
	private LanceBean map(ResultSet rs) throws SQLException {
        LanceBean resultado = new LanceBean(rs.getInt("id_pedido_compra"),
        		rs.getInt("id_fornecedor"), rs.getFloat("total"),
        		rs.getInt("quantidade_parcelas"), rs.getInt("prazo_entrega"),
        		rs.getDate("data"), rs.getBoolean("is_fora_padrao"));
        return resultado;
    }
	
	public void inserirProposta(int idPedidoCompra, int idFornecedor, float total, int qtdParcelas, int prazoEntrega,
			Date dataLance, boolean isForaDoPadrao) throws DAOException{
        Connection con = null;
        try {
            con = new ConnectionFactory().conectar("leilao");
            String insert_sql = "insert into proposta (id_pedido_compra, id_fornecedor, total, quantidade_parcelas, prazo_entrega, data, is_fora_padrao) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setInt(1, idPedidoCompra);
            pst.setInt(2, idFornecedor);
            pst.setFloat(3, total);
            pst.setInt(4, qtdParcelas);
            pst.setInt(5, prazoEntrega);
            pst.setDate(6, dataLance);
            pst.setBoolean(7, isForaDoPadrao);
            //Executando os comandos
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
	}
	
	public void inserirLance(int idItem,int idPedidoCompra, int idFornecedor, float valor) throws DAOException{
        Connection con = null;
        try {
        	con = new ConnectionFactory().conectar("leilao");
        	String insert_sql = "insert into lance (id_item, id_pedido_compra, id_fornecedor, valor) values (?, ?, ?, ?)";
        	PreparedStatement pst;
        	pst = con.prepareStatement(insert_sql);
        	//Passando os paramentros para o SQL
        	pst.setInt(1, idItem);
            pst.setInt(2, idPedidoCompra);
            pst.setInt(3, idFornecedor);
            pst.setFloat(4, valor);
            //Executando os comandos
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
	}
	
	public void updateProposta(int idPedidoCompra, int idFornecedor, float total, int qtdParcelas, int prazoEntrega,
			Date dataLance, boolean isForaDoPadrao) throws DAOException{
        Connection con = null;
        try {
            con = new ConnectionFactory().conectar("leilao");
            String insert_sql = "update proposta set id_pedido_compra = ?, id_fornecedor = ?, total = ?, quantidade_parcelas = ?, prazo_entrega = ?, data = ?, is_fora_padrao = ? where id_pedido_compra = ? and id_fornecedor = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setFloat(1, total);
            pst.setInt(2, qtdParcelas);
            pst.setInt(3, prazoEntrega);
            pst.setDate(4, dataLance);
            pst.setBoolean(5, isForaDoPadrao);
            pst.setInt(6, idPedidoCompra);
            pst.setInt(7, idFornecedor);
            //Executando os comandos
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
    }
	
	public void updateLance(int idItem,int idPedidoCompra, int idFornecedor, float valor) throws DAOException{
        Connection con = null;
        try {
            con = new ConnectionFactory().conectar("leilao");
            String insert_sql = "update lance set valor = ? where id_item = ? and id_pedido_compra = ? and id_fornecedor = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setFloat(1, valor);
            pst.setInt(2, idItem);
            pst.setInt(3, idPedidoCompra);
            pst.setInt(4, idFornecedor);
            //Executando os comandos
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
    }

    public void deleteProposta(int idPedidoCompra, int idFornecedor) throws DAOException{
        Connection con = null;
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "delete from proposta where id_pedido_compra = ? and id_fornecedor = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idPedidoCompra);
            pst.setInt(2, idFornecedor);
            pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
    }

    public void deleteLance(int idItem,int idPedidoCompra, int idFornecedor) throws DAOException{
        Connection con = null;
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "delete from lance where id_item = ? and id_pedido_compra = ? and id_fornecedor = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idItem);
            pst.setInt(2, idPedidoCompra);
            pst.setInt(3, idFornecedor);
            pst.executeUpdate();
            pst.close();
            con.close();
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
    }
    
	public LanceBean encontrarProposta(int idPedidoCompra, int idFornecedor) throws DAOException{
        Connection con = null;
        LanceBean lance = null;
                
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from proposta where id_pedido_compra = ? and id_fornecedor = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idPedidoCompra);
            pst.setInt(2, idFornecedor);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lance = map(rs);
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return lance;
    }
	
	public float encontrarLance(int idItem, int idPedidoCompra, int idFornecedor) throws DAOException{
        Connection con = null;
        float lance = 0;
                
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from lance where id_item = ? and id_pedido_compra = ? and id_fornecedor = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idItem);
            pst.setInt(2, idPedidoCompra);
            pst.setInt(3, idFornecedor);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                lance = rs.getFloat("valor");
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return lance;
    }
	
	public ArrayList<LanceBean> mostrarTodasPropostas() throws DAOException {
        Connection con = null;
        ArrayList<LanceBean> propostas = new ArrayList<>();
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from proposta";
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	propostas.add(map(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return propostas;
    }
	
	public ArrayList<Float> mostrarTodosLances(int idPedidoCompra, int idFornecedor) throws DAOException {
        Connection con = null;
        ArrayList<Float> lances = new ArrayList<>();
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from lance where id_pedido_compra = ? and id_fornecedor = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idPedidoCompra);
            pst.setInt(2, idFornecedor);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	lances.add(rs.getFloat("valor"));
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return lances;
    }
	public ArrayList<LanceBean> mostrarTodosLances(int idPedidoCompra) throws DAOException {
        Connection con = null;
        ArrayList<LanceBean> lances = new ArrayList<>();
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from lance, proposta where id_pedido_compra = ? and lance.id_fornecedor = proposta.id_fornecedor";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idPedidoCompra);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	lances.add(map(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return lances;
    }
	public ArrayList<LanceBean> mostrarTodasPropostasPedido(int idPedidoCompra) throws DAOException {
        Connection con = null;
        ArrayList<LanceBean> propostas = new ArrayList<>();
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from proposta where id_pedido_compra = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idPedidoCompra);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	propostas.add(map(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return propostas;
    }
	
	public ArrayList<LanceBean> mostrarTodasFornecedor(int idFornecedor) throws DAOException {
        Connection con = null;
        ArrayList<LanceBean> propostas = new ArrayList<>();
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from proposta where id_fornecedor = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idFornecedor);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
            	propostas.add(map(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Operação não realizada com sucesso.", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new DAOException("Não foi possível fechar a conexão.", e);
            }
        }
        return propostas;
    }
}
