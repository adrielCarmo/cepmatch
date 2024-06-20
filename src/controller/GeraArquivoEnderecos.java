package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Endereco;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeraArquivoEnderecos {
    public void salvaEndereco(List<Endereco> enderecos) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter fw = new FileWriter("enderecos.json");
        fw.write(gson.toJson(enderecos));
        fw.close();
    }
}
