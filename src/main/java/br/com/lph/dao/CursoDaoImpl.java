package br.com.lph.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.lph.domain.Curso;

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
		entityManager.detach(entityManager.getReference(Curso.class, id));
		
	}

	@Override
	public Curso findById(Long id) {
		return entityManager.find(Curso.class, id);
	}

	@Override
	public List<Curso> findAll() {
		return entityManager.createQuery("select c from Curso c", Curso.class).getResultList();
	}
}
