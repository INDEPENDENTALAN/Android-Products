package com.android.products

import android.app.Activity
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import com.android.products.sqlite.ProductSQLite
import kotlinx.android.synthetic.main.fragment_products.*
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.junit.*
import java.util.concurrent.Executor

class FragmentUnitTest {

    //
    private lateinit var name: String
    private lateinit var password: String
    private lateinit var activity: Activity
    private lateinit var price: String
    private lateinit var details: String
    lateinit var productSQLite: ProductSQLite

    @BeforeClass
    fun fragmentBeforeClass() {
        //
    }

    @Before
    fun signInBefore() {
        //
        name = "android@developer.com"
        password = "developer,_android"
    }

    @Test
    fun signInTest() {
        //
        if (name.equals(activity!!.getSharedPreferences("Accounts",
                        AppCompatActivity.MODE_PRIVATE
                ).getString("name", "")) && password.equals(activity!!.getSharedPreferences("Accounts",
                        AppCompatActivity.MODE_PRIVATE
                ).getString("password", ""))) {
            //
            activity!!.getSharedPreferences("Accounts", AppCompatActivity.MODE_PRIVATE).edit().putInt("sign", 0).apply()
            Assert.assertTrue("Success", true)
        } else {
            Assert.assertFalse("Failed", false)
        }

    }

    @After
    fun signInAfter() {
        //
    }

    @Before
    fun signUpBefore() {
        //
        name = "android@developer.com"
        password = "developer,_android"
    }

    @Test
    fun signUpTest() {
        //
        activity!!.getSharedPreferences("Accounts", AppCompatActivity.MODE_PRIVATE).edit().putString("name", name).putString("password", password).putInt("sign", 0).apply()
        Assert.assertTrue("Success", true)
    }

    @After
    fun signUpAfter() {
        //
    }

    @Before
    fun productBefore() {
        //
        name = "android@developer.com"
        price = "26$"
        details = "developer,_android"
        productSQLite = ProductSQLite(activity!!)
    }

    @Test
    fun productTest() {
        //
        if (name.isNotEmpty() && price.isNotEmpty() && details.isNotEmpty()) {
            //
            val db: SQLiteDatabase = productSQLite.getWritableDatabase()
            val contentValues = ContentValues()
            contentValues.put("name", name)
            contentValues.put("price", price)
            contentValues.put("details", details)
            if (activity!!.getSharedPreferences("Products", AppCompatActivity.MODE_PRIVATE).getInt("product", -1) == 0) {
                //
                db.insert("products", null, contentValues)
                Assert.assertTrue("Success", true)
            } else if (activity!!.getSharedPreferences("Products", AppCompatActivity.MODE_PRIVATE).getInt("product", -1) == 1) {
                //
                //db.update("products", contentValues, "_id = ? ", arrayOf(id.toString()))
                Assert.assertTrue("Success", true)
            } else {
                Assert.assertFalse("Failed", false)
            }
        }
    }

    @After
    fun productAfter() {
        //
    }

    @AfterClass
    fun fragmentAfterClass() {
        //
    }
}