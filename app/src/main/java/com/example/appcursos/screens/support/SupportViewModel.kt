package com.example.appcursos.screens.support

import androidx.lifecycle.ViewModel

class SupportViewModel:ViewModel() {
    private val _messages = mutableListOf(
        Message("Gostaria de ajuda com algo mais?", UserType.SUPPORT),
        Message("Problema resolvido! Pedimos perdão pelo transtorno", UserType.SUPPORT),
        Message("Vou verificar, só um momento.", UserType.SUPPORT),
        Message("Certo! Comprei um curso faz uma semana, mas ele ainda não está aparecendo nos meus cursos.", UserType.ME),
        Message("Claro! Mas você poderia ser um pouco mais específico?", UserType.SUPPORT),
        Message("Olá, estou tendo um problema para acessar o curso X. Pode me ajudar?", UserType.ME),
        Message("Olá, bom dia. Você está falando com o supporte.", UserType.SUPPORT),
    )

    var messages: MutableList<Message> = _messages

    fun addMessage(message:String){
        messages.add(Message(message, UserType.ME))
    }
}