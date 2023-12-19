package cl.inacap.firebase171iei;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import kotlin.jvm.internal.CollectionToArray;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // creamos objetos para asociar layout

    EditText edtFecha;
    EditText edtPatente;
    EditText edtComentario;
    Spinner spnEstado;
    Button btnEnviar;
    //creamos una variable de objeto de la clase firebase firestore
    private Firebasefirestore firebasefirestore;
    Entrada entrada;
    String fecha,comentario,estado,patente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vincularElemento();
        habilitarListener();
        iniciarFirestore();
    }

    private void iniciarFirestore() {
        firebasefirestore = FirebaseFirestore.getInstance();
    }

    private void habilitarListener() {
        btnEnviar.setOnClickListener(this);
    }

    private void vincularElemento() {
        edtFecha = (EditText) findViewById(R.id.edt_fecha);
        edtPatente = (EditText) findViewById(R.id.edt_patente);
        edtComentario = (EditText) findViewById(R.id.edt_comentario);
        btnEnviar = (Button) findViewById(R.id.btn_enviar);
        spnEstado = (Spinner) findViewById(R.id.spn_estado);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spn_estado,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// asosciamos arrayList al spinner
        spnEstado.setAdapter(adapter);


    }

    @Override
    public void onClick(View view) {
        // verificamos si se click en el boton enviar
        if (view.getId() == R.id.btn_enviar) {
            // obtenemos la fecha de ingreso
            String fechaIngreso = edtFecha.getText().toString();
            // Establecemos un formato de fecha año-mes-dia
            SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date fechaFormateada = formatoFecha.parse(fechaIngreso);
                fecha = fechaFormateada;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            patente = edtPatente.getText().toString();
            comentario = edtComentario.getText().toString();
            // obtenemos el valor seleccionado el spinner
            estado = spnEstado.getSelectedItem().toString();

            // enviamos a firestore
            agregarFirestore(fecha,patente,estado,comentario);
        }
    }

    private void agregarFirestore(String fecha, String patente, String estado, String comentario) {
        // coleccion en firestore

    }
}