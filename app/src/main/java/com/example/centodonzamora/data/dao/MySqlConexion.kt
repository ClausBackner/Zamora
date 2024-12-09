package com.example.centodonzamora.data.dao

import java.sql.DriverManager

object MySqlConexion {
    fun getConexion(): java.sql.Connection? {
        Class.forName("com.mysql.jdbc.Driver")

        return DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1:3306/blog","root","root"
        )
    }
}