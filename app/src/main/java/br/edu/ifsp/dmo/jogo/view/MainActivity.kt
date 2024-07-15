package br.edu.ifsp.dmo.jogo.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.dmo.jogo.R
import android.content.Intent
import android.widget.ArrayAdapter
import br.edu.ifsp.dmo.jogo.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configToolBar()
        configSpinner()
        configListener()
    }

    private fun configListener() {
        binding.buttonStart.setOnClickListener { startGame() }
    }

    private fun configSpinner() {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.tipos_jogos)
        )

        binding.spinnerButtles.adapter = adapter
    }

    private fun configToolBar(){
        supportActionBar?.hide()
    }

    private fun startGame() {
        var battles: Int = when ( binding.spinnerButtles.selectedItemPosition){
            0 -> 1
            1 -> 3
            else -> 5
        }

        val mIntent = Intent(this, WarActivity::class.java)
        mIntent.putExtra(Constants.KEY_PLAYER_1,binding.edittextPlayer1.text.toString())
        mIntent.putExtra(Constants.KEY_PLAYER_2,binding.edittextPlayer2.text.toString())
        mIntent.putExtra(Constants.KEY_ROUNDS, battles)
        startActivity(mIntent)

    }

}
