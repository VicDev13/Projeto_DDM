package br.com.ddm.hogwartshistories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val intent =  Intent(this, CasasActivity::class.java)

        botao_grifinoria.setOnClickListener {
            val botao_grifinoria = botao_grifinoria.text.toString()
            val params = Bundle()
            params.putString("botao", botao_grifinoria)
            intent.putExtras(params)
            startActivity(intent)
        }

        botao_sonserina.setOnClickListener{
            val botao_sonserina = botao_sonserina.text.toString()
            val params = Bundle()
            params.putString("botao", botao_sonserina)
            intent.putExtras(params)
            startActivity(intent)
        }

        botao_lufalufa.setOnClickListener{
            val botao_fufalufa = botao_lufalufa.text.toString()
            val params = Bundle()
            params.putString("botao", botao_fufalufa)
            intent.putExtras(params)
            startActivity(intent)
        }

        botao_corvinal.setOnClickListener {
            val botao_corvinal = botao_corvinal.text.toString()
            val params = Bundle()
            params.putString("botao", botao_corvinal)
            intent.putExtras(params)
            startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_atualizar) {
            progressBar.setVisibility(View.VISIBLE)
            var c = 0
            while (c <= 2) {
                c++
            }
            if (c == 2) {
                Toast.makeText(this, "dsdsd", Toast.LENGTH_SHORT).show()
            }
        } else if (id == R.id.action_configurar) {
            val intent = Intent(this, ConfiguracoesActivity::class.java)
            startActivity(intent)
        } else if (id == R.id.action_sair) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}