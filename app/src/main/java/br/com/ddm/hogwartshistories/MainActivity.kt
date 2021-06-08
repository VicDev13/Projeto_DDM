package br.com.ddm.hogwartshistories

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.tela_login.*

class MainActivity : AppCompatActivity() {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_login)
        campo_usuario.setText(Prefs.getString("nome_usuario"))
        campo_senha.setText(Prefs.getString("senha_usuario"))
        checkLogin.isChecked = Prefs.getBoolean("check_login")

        val context: Context = this

        login_botao.setOnClickListener {

            Handler(Looper.getMainLooper()).postDelayed({
                val nome_usuario = campo_usuario.text.toString()
                val senha_usuario = campo_senha.text.toString()
                val check_login = checkLogin.isChecked

                progress_login.visibility = View.VISIBLE

                Thread{

                    val usuario = UsuarioService.getUsuario(nome_usuario)

                    runOnUiThread{
                        if ((nome_usuario == usuario?.nome) && (senha_usuario == usuario?.senha)) {

                            if (check_login) {

                                Prefs.setString("nome_usuario", nome_usuario)
                                Prefs.setString("senha", senha_usuario)

                            }else {

                                Prefs.setString("nome_usuario", "")
                                Prefs.setString("senha", "")

                            }

                            Prefs.setBoolean("check_login", check_login)

                            val intent = Intent(context, TelaInicialActivity::class.java)
                            startActivity(intent)


                        } else {
                            Toast.makeText(context, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
                        }
                    }
                }.start()
            }, 1000)
        }

        login_cadastro.setOnClickListener{
            progress_login.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed(
                    {
                        val intent = Intent(context, CadastroActivity::class.java)
                        startActivity(intent)
                    }, 1000)
        }

    }

    override fun onResume() {
        super.onResume()
        progress_login.visibility = View.GONE
    }


}