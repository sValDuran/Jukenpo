package br.edu.ifsp.dmo.jogo.model

class Player(val name: String) {
    var points: Int = 0
        private set

    fun recordPoint(){
        points+=1
    }
}
