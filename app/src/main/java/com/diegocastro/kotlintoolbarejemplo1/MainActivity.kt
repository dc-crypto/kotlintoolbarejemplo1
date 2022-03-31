package com.diegocastro.kotlintoolbarejemplo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    var f1: F1=F1()
    var f2: F2=F2()
    var f3: F3=F3()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myToolbar: Toolbar =findViewById(R.id.myToolbar)
        setSupportActionBar(myToolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        cargarFragmento(f1)


        //llamamos al action bar
        setSupportActionBar(findViewById(R.id.myToolbar));

    }

    fun cargarFragmento(f: Fragment) {
        val fragmentManager=supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.myFrame,f)
        fragmentTransaction.commit()

    }

   override fun onCreateOptionsMenu(menu:Menu?): Boolean {
       menuInflater.inflate(R.menu.menu, menu)
       return super.onCreateOptionsMenu(menu)
   }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.registrar-> cargarFragmento(f1);
            R.id.buscar -> cargarFragmento(f2);
            R.id.modificar-> cargarFragmento(f3);

        }
        return super.onOptionsItemSelected(item)
    }


}