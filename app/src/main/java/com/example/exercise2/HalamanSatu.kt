package com.example.exercise2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exercise2.ui.theme.Exercise2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    pilihanDosen: List<String>,
    onSelectionChanged: (String) -> Unit,
    onConfirmButtonClicked: (Int) -> Unit,
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
)
{
    var DosenYgDipilih by rememberSaveable{ mutableStateOf("") }


    Column (modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween){
        Column (modifier =
        Modifier.padding(dimensionResource(R.dimen.padding_medium))){
            pilihanDosen.forEach{ item->
                Row(modifier = Modifier.selectable(
                    selected = DosenYgDipilih == item,
                    onClick = {
                        DosenYgDipilih = item
                        onSelectionChanged(item)
                    }
                ),
                    verticalAlignment = Alignment.CenterVertically){

                    RadioButton(selected = DosenYgDipilih == item,
                        onClick = {
                            DosenYgDipilih = item
                            onSelectionChanged(item) }
                    )
                    Text(item)
                }
            }
            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom =
                dimensionResource(R.dimen.padding_medium)
                )
            )
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            ){

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f, false),
                horizontalArrangement =
                Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.Bottom
            ){
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = onCancelButtonClicked) {
                    Text(stringResource(R.string.cancel))
                }
                    Text(stringResource(R.string.next))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pelanggan(
    onConfirmButtonClicked: (String, String, String, String) -> Unit,
    onCancelButtonClicked: () -> Unit
){
    var namaMahasiswa by remember { mutableStateOf("") }
    var NIM by remember { mutableStateOf("")}
    var Konsentrasi by remember{ mutableStateOf("")}
    var Judul by remember{ mutableStateOf("")}

    Column (
    modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        OutlinedTextField(
            value = namaMahasiswa,
            onValueChange = { namaMahasiswa = it },
            label = { Text(text = "Nama Mahasiswa") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
        )
        OutlinedTextField(
            value = NIM,
            onValueChange = { NIM = it },
            label = { Text(text = "NIM") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Companion.Phone
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
        )
        OutlinedTextField(
            value = Konsentrasi,
            onValueChange = { Konsentrasi = it },
            label = { Text(text = "Konsentrasi") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
        )
        OutlinedTextField(
            value = Judul,
            onValueChange = { Judul = it },
            label = { Text(text = "Judul Skripsi") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(onClick = onCancelButtonClicked) {
                Text(text = "Cancel")
            }
            Button(
                onClick = {
                    if (namaMahasiswa.isNotEmpty() && NIM.isNotEmpty() && Konsentrasi.isNotEmpty() && Judul.isNotEmpty()) {
                        onConfirmButtonClicked(namaMahasiswa, NIM, Konsentrasi, Judul)
                    }
                })
            {
                Text(text = "Next")
            }
        }
    }
}



