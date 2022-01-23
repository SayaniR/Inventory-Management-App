/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package struts2.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import struts2.test.beans.Product;
import struts2.test.beans.User;
import struts2.test.core.ConnectionManager;

/**
 *
 * @author Sayani
 */
public class Products {

    public int addProducts(int productId, String productName, double price, int availability) throws Exception {
        int i = 0;
        Connection con = null;
        try {

            con = ConnectionManager.getConnection();
            String sql = "INSERT INTO products\n"
                    + "VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            ps.setString(2, productName);
            ps.setDouble(3, price);
            ps.setInt(4, availability);
            System.out.println("SQL for insert=" + ps);
            i = ps.executeUpdate();
            return i;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return i;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public List reportProduct() throws SQLException, Exception {
        ResultSet rs = null;
        Connection con = null;
        List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM products";
            con = ConnectionManager.getConnection();
            System.out.println("Connection is " + con);
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();

                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getDouble("price"));
                product.setAvailability(rs.getInt("availability"));

                productList.add(product);
            }
            return productList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public Product fetchProductDetails(int productId) throws SQLException, Exception {

        ResultSet rs = null;
        Connection con = null;
        Product product = new Product();
        try {
            con = ConnectionManager.getConnection();
            String sql = "SELECT * FROM products WHERE productId=?";

            PreparedStatement ps = con.prepareStatement(sql);
            System.out.println("productId = " + productId);
            ps.setInt(1, productId);
            System.out.println("Select SQL = " + ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setPrice(rs.getDouble("price"));
                product.setAvailability(rs.getInt("availability"));
            }
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public int updateProductDetails(int productId, String productName, double price, int availability)
            throws SQLException, Exception{
        Connection con = ConnectionManager.getConnection();
        int i = 0;
        try {

            String sql = "UPDATE products SET productId= ?,productName =?,price = ?,availability = ?\n"
                    + "WHERE productId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1,productId);
            ps.setString(2,productName);
            ps.setDouble(3,price);
            ps.setInt(4,availability);
            ps.setInt(5,productId);
            System.out.println("Select SQL = " + ps);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
    
//    public int deleteProductDetails(int productId) throws SQLException, Exception {
//        Connection con = ConnectionManager.getConnection();
//        int i = 0;
//        try {
//            String sql = "UPDATE users SET status = 0 WHERE userName = ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, userName);
//            i = ps.executeUpdate();
//            return i;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        } finally {
//            if (con != null) {
//                con.close();
//            }
//        }
//    }
}
