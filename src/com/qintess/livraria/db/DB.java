package com.qintess.livraria.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

	private static Connection conn = null;

	public static Connection getConnection() {// Vai pegar a conexão

		if (conn == null) {// se estiver valendo nulo ele vaii conectar com o banco

			try {

				Properties props = loadProperties();// Vai pegar as propiedades de conexão.
				String url = props.getProperty("dburl");// vai pegar a url do banco
				conn = DriverManager.getConnection(url, props);// passou a url e as propiedades
				System.out.println("Conectou");

			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}

		return conn;

	}

	public static void closeConection() {

		if (conn != null) {// Vai verificar se há alguma conexão se tiver vai fechar

			try {

				conn.close();// fechando a conexão
				System.out.println("Desconectou!!");
			} catch (SQLException e) {

				throw new DbException(e.getMessage());

			}
		}

	}

	private static Properties loadProperties() {

		try (FileInputStream fs = new FileInputStream(
				"C:\\Users\\re039841\\eclipse-workspace-web\\com.qintess.livraria\\src\\db.properties")) {

			Properties props = new Properties();
			props.load(fs);// Ele vai ler o arquivo do FileInputStream
			return props;// vai retornar o arquivo

		} catch (IOException e) {

			throw new DbException(e.getMessage());
		}

	}

	public static void closeStatement(Statement st) {// foi criado um metodo para fechar a conexão do Statement

		if (st != null) {
			try {
				st.close();
				System.out.println("Closed Statement!");
			} catch (SQLException e) {

				throw new DbException(e.getMessage());
			}
		}

	}

	public static void closeResultSet(ResultSet rs) {// foi criado um metodo para fechar a conexão do ResultSet

		if (rs != null) {
			try {
				rs.close();
				System.out.println("Close ResultSet");
			} catch (SQLException e) {

				throw new DbException(e.getMessage());
			}
		}

	}

}
