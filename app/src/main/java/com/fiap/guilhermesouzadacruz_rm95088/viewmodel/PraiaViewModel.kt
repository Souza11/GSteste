package com.fiap.guilhermesouzadacruz_rm95088.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.fiap.guilhermesouzadacruz_rm95088.model.Praia

class PraiaViewModel : ViewModel() {
    private val _items = MutableStateFlow<List<Praia>>(emptyList())
    val items: StateFlow<List<Praia>> = _items

    fun addItem(item: Praia) {
        _items.value = _items.value + item
    }

    fun removeItem(item: Praia) {
        _items.value = _items.value - item
    }
}
