package br.com.lph.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lph.dao.CursoDao;
import br.com.lph.domain.Curso;
import br.com.lph.exception.IdNaoValidoServiceException;

@Service
@Transactional
public class CursoServiceImpl implements CursoService{

	@Autowired
	private CursoDao dao;
	
	@Override
	public void save(Curso curso) {
		dao.save(curso);
	}

	@Override
	public void update(Long id, Curso curso) {
		curso.setId(idValido(id));
		dao.update(curso);
	}

	@Override
	public void delete(Long id) {
		dao.delete(idValido(id));
	}

	@Override @Transactional(readOnly = true)
	public Curso findById(Long id) {
		return dao.findById(idValido(id));
	}
	
	@Override @Transactional(readOnly = true)
	public List<Curso> findAll() {
		return dao.findAll();
	}

	@Override
	public Curso updateDataInicio(Long id, Date dataInicio) {
		Curso curso = dao.findById(idValido(id));
		curso.setDataInicio(dataInicio);
		return curso;
	}

	public Long idValido(Long id) {
		if (id <= 0) {
			throw new IdNaoValidoServiceException("Valor do campo id está invalido. "+
												" Deve ser um valor inteiro maior que zero.");
		}
		return id;
	}

}
