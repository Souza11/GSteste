package com.fiap.guilhermesouzadacruz_rm95088

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiap.guilhermesouzadacruz_rm95088.model.Praia
import com.fiap.guilhermesouzadacruz_rm95088.ui.theme.GuilhermeSouzadaCruz_RM95088Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuilhermeSouzadaCruz_RM95088Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppContent()
                }
            }
        }
    }
}

@Composable
fun AppContent(viewModel: PraiaViewModel = viewModel()) {
    var nomePraia by remember { mutableStateOf(TextFieldValue("")) }
    var cidade by remember { mutableStateOf(TextFieldValue("")) }
    var estado by remember { mutableStateOf(TextFieldValue("")) }
    val praias by viewModel.items.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Cadastro de Praias", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = nomePraia,
            onValueChange = { nomePraia = it },
            label = { Text("Nome da praia") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = cidade,
            onValueChange = { cidade = it },
            label = { Text("Cidade") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = estado,
            onValueChange = { estado = it },
            label = { Text("Estado") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (nomePraia.text.isNotBlank() && cidade.text.isNotBlank() && estado.text.isNotBlank()) {
                    val novaPraia = Praia(nomePraia.text, cidade.text, estado.text)
                    viewModel.addItem(novaPraia)
                    nomePraia = TextFieldValue("")
                    cidade = TextFieldValue("")
                    estado = TextFieldValue("")
                } else {
                    // Tratar erro: Campos não preenchidos
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Incluir")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(praias) { praia ->
                PraiaItem(praia = praia, onDelete = { viewModel.removeItem(it) })
            }
        }
    }
}

@Composable
fun PraiaItem(praia: Praia, onDelete: (Praia) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = praia.nome, style = MaterialTheme.typography.body1)
            Text(text = "${praia.cidade}, ${praia.estado}", style = MaterialTheme.typography.body2)
        }
        Button(onClick = { onDelete(praia) }) {
            Text("Excluir")
        }
    }
}
