package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import control.PedidoCompraBean;

public class PedidoCompraDAO {
	
	private PedidoCompraBean map(ResultSet rs) throws SQLException {
        PedidoCompraBean resultado = new PedidoCompraBean(rs.getInt("id"),
        		rs.getDate("data_inicio"), rs.getDate("data_fim"),
        		rs.getString("id_usuario"), rs.getBoolean("is_interno"));
        return resultado;
    }
	
	public void inserir(Date dataInicio, Date dataFim, String idUsuario,
			boolean isInterno) throws DAOException{
        Connection con = null;
        try {
            con = new ConnectionFactory().conectar("leilao");
            String insert_sql = "insert into pedido_compra (data_inicio, data_fim, id_usuario, is_interno) values (?, ?, ?, ?)";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setDate(1, dataInicio);
            pst.setDate(2, dataFim);
            pst.setString(3, idUsuario);
            pst.setBoolean(4, isInterno);
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
	
	public void update(int id, Date dataInicio, Date dataFim, String idUsuario,
			boolean isInterno) throws DAOException{
        Connection con = null;
        try {
            con = new ConnectionFactory().conectar("leilao");
            String insert_sql = "update pedido_compra set data_inicio = ?, data_fim = ?, id_usuario = ?, is_interno = ? where id = ?";
            PreparedStatement pst;
            pst = con.prepareStatement(insert_sql);
            //Passando os paramentros para o SQL
            pst.setDate(1, dataInicio);
            pst.setDate(2, dataFim);
            pst.setString(3, idUsuario);
            pst.setBoolean(4, isInterno);
            pst.setInt(5, id);
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

    public void delete(int id) throws DAOException{
        Connection con = null;
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "delete from pedido_compra where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
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

	public PedidoCompraBean encontrar(int id) throws DAOException{
        Connection con = null;
        PedidoCompraBean ped = null;
                
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from pedido_compra where id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ped = map(rs);
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
        return ped;
    }
	
	public ArrayList<PedidoCompraBean> mostrarTodos() throws DAOException {
        Connection con = null;
        ArrayList<PedidoCompraBean> pedido_compraes = new ArrayList<>();
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from pedido_compra";
            PreparedStatement pst = con.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pedido_compraes.add(map(rs));
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
        return pedido_compraes;
    }
	public ArrayList<PedidoCompraBean> mostrarPedidosUsuario(String idUsuario) throws DAOException {
        Connection con = null;
        ArrayList<PedidoCompraBean> pedido_compraes = new ArrayList<>();
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from pedido_compra where id_usuario = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, idUsuario);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pedido_compraes.add(map(rs));
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
        return pedido_compraes;
    }
	public ArrayList<PedidoCompraBean> mostrarPedidosCategoria(int idCategoria) throws DAOException {
        Connection con = null;
        ArrayList<PedidoCompraBean> pedido_compraes = new ArrayList<>();
        try {
            con = new ConnectionFactory().conectar("leilao");
            String sql = "select * from pedido_compra, item, produto where item.id_pedido_compra = pedido_compra.id and item.id_produto = produto.id and produto.id_categoria = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idCategoria);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pedido_compraes.add(map(rs));
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
        return pedido_compraes;
    }
}
