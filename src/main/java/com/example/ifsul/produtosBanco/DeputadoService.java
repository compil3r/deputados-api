package com.example.ifsul.produtosBanco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeputadoService {

		@Autowired
		private DeputadoRepository depRepo;
		
		public List<Deputado> listar() {
			return depRepo.findAll();
		}
		
		public Deputado criar(Deputado deputado) {
			return depRepo.save(deputado);
		}
}
