package com.android.products

import android.app.Activity
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import com.android.products.adapter.HomeAdapter
import com.android.products.entity.ProductsEntity
import com.android.products.sqlite.ProductSQLite
import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass

class ProductsUnitTest {

    lateinit var productSQLite: ProductSQLite
    private lateinit var activity: Activity
    lateinit var arrayList: ArrayList<ProductsEntity>
    lateinit var productsEntity: ProductsEntity
    lateinit var cursor: Cursor
    @BeforeClass
    fun fragmentBeforeClass() {
        //
    }

    @Before
    fun productBefore() {
        //
        arrayList = ArrayList()
        productSQLite = ProductSQLite(activity!!)
    }

    @Test
    fun homeTest() {
        val db: SQLiteDatabase = productSQLite.getReadableDatabase()
        cursor = db.rawQuery("SELECT * FROM products", null)
        cursor.moveToFirst()
        cursor.count
        do {
            if (cursor.count != 0) {
                productsEntity = ProductsEntity(
                        cursor.getInt(cursor.getColumnIndex("_id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("image")),
                        cursor.getString(cursor.getColumnIndex("price")),
                        cursor.getString(cursor.getColumnIndex("details"))
                )
                arrayList.add(productsEntity)
            }

        } while(cursor.moveToNext())
        db.close()

    }
}