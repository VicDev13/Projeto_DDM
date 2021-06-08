package br.com.ddm.hogwartshistories

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        botao_cadastro.setOnClickListener{
            val nomeTexto = nome_usuario.text.toString()
            val senhaTexto = senha_usuario.text.toString()

            val u = Usuario()
            u.nome = nomeTexto
            u.senha = senhaTexto

            Thread{
                UsuarioService.saveUsuario(u)
                runOnUiThread{
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }.start()
        }
    }
}
