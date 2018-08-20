package br.com.lph.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.lph.domain.Curso;
import br.com.lph.exception.NaoExisteDaoException;


@Repository
public class CursoDaoImpl implements CursoDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(Curso curso) {
		entityManager.persist(curso);
		
	}

	@Override
	public void update(Curso curso) {
		entityManager.merge(curso);
		
	}

	@Override
	public void delete(Long id) {
		try {
		entityManager.remove(entityManager.getReference(Curso.class, id));
		} catch (EntityNotFoundException ex) {
			throw new NaoExisteDaoException("Curso id: "+id+" não encontrado.");
		}
		
	}

	@Override
	public Curso findById(Long id) {
		Curso curso = entityManager.find(Curso.class, id);
		if (curso == null) {
			throw new NaoExisteDaoException("Curso id: "+id+" não encontrado.");
		}
		return curso;
	}

	@Override
	public List<Curso> findAll() {
		return entityManager.createQuery("select c from Curso c", Curso.class).getResultList();
	}
}
