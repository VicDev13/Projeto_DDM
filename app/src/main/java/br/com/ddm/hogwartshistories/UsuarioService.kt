package br.com.ddm.hogwartshistories
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object UsuarioService {

    val host = "https://mvitoria.pythonanywhere.com"
    val TAG = "WS_HH"

    fun getUsuarios (context: Context) : List<Usuario> {

        val url ="$host/usuarios"
        val json = HttpHelper.get(url)
        Log.d(TAG, json)

        return parseJson<List<Usuario>>(json)
    }

    fun getUsuario(nome: String):Usuario? {
        val url = "$host/usuarios/$nome"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)

        if (json.equals("Usuario nao existe")){
            return null
        }
        
        return parseJson<Usuario>(json)
    }

    fun saveUsuario(usuario: Usuario) : String {
        val json = HttpHelper.post("$host/usuarios", usuario.toJson())
        return json
    }


    inline fun <reified T> parseJson(json: String) : T {
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}