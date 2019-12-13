package com.example.trabalho_android_avancado

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class MyDatabase(context: Context) : SQLiteOpenHelper(context, "trabalhos03ep03.db", null, 1) {

    companion object {

        const val TAG = "MyDatabase"
        const val TABLE = "logs"
        const val ID: String = "ID"
        const val LOGIN : String = "Login"
        const val PASSWD: String = "PasswordP"
        const val CPF: String = "CPF"
        const val EMAIL:String = "meuemail@email.com"
    }


    val DATABASE_CREATE =
        "CREATE TABLE if not exists " + TABLE + " (" +
                "${ID} integer PRIMARY KEY autoincrement," +
                "${LOGIN} text," +
                "${PASSWD} text," +
                "${CPF} integer," +
                "${EMAIL} text"+
                ")"

    fun insertLog(login: String, password: String, cpf: String, email: String) {
        val values = ContentValues()
        values.put(LOGIN, login)
        values.put(PASSWD, password)
        values.put(CPF, cpf)
        values.put(EMAIL, email)
        writableDatabase.insert(TABLE, null, values);
    }


     fun getLogs(): Cursor {
        return readableDatabase
            .query(TABLE, arrayOf(ID, LOGIN, PASSWD, CPF, EMAIL), null, null, null, null, null);
    }

    fun updateLog(id: Int, text: String) {
        val values = ContentValues()
        values.put(LOGIN, text)
        values.put(PASSWD, text)
        values.put(CPF, text)
        values.put(EMAIL, text)
        getWritableDatabase().update(TABLE, values, "${ID}=${id}", null)
    }

    fun removeLog(id: Int): Int {
        return writableDatabase.delete(TABLE, "${ID}=${id}", null)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("MyDatabase", "Creating: $DATABASE_CREATE")
        db?.execSQL(DATABASE_CREATE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS" + TABLE);
        onCreate(db);
    }

}