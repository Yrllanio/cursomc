package com.yrllanio.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yrllanio.cursomc.domain.Categoria;
import com.yrllanio.cursomc.domain.Cidade;
import com.yrllanio.cursomc.domain.Cliente;
import com.yrllanio.cursomc.domain.Endereco;
import com.yrllanio.cursomc.domain.Estado;
import com.yrllanio.cursomc.domain.Produto;
import com.yrllanio.cursomc.domain.enums.TipoCliente;
import com.yrllanio.cursomc.repositories.CategoriaRepository;
import com.yrllanio.cursomc.repositories.CidadeRepository;
import com.yrllanio.cursomc.repositories.ClienteRepository;
import com.yrllanio.cursomc.repositories.EnderecoRepository;
import com.yrllanio.cursomc.repositories.EstadoRepository;
import com.yrllanio.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeReository;
	@Autowired
	private ClienteRepository clienteReository;
	@Autowired
	private EnderecoRepository enderecoReository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeReository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("27363323", "43231233"));

		Endereco e1 = new Endereco(null, "Rua Flores", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);

		cli1.getEndereco().addAll(Arrays.asList(e1, e2));

		clienteReository.saveAll(Arrays.asList(cli1));
		enderecoReository.saveAll(Arrays.asList(e1, e2));

	}

}
