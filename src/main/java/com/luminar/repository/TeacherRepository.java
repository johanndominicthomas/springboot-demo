package com.luminar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luminar.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}

/*
 * Marking the interface with @Repository indicates that it belongs to the data access
 * layer and enables Spring’s exception translation, converting low-level persistence
 * exceptions into Spring’s unified DataAccessException hierarchy.
 * SQLException which is checked is translated to DataAccessException which is unchecked
 * and doesnt have to handled during compilation
 *
 * Extending JpaRepository<Teacher, Long> specifies the entity type managed by the
 * repository and the type of its primary key. This inheritance provides built-in CRUD,
 * paging, and sorting operations without requiring manual implementation. At runtime,
 * Spring Data JPA generates a proxy implementation that uses the EntityManager to
 * interact with the database, allowing developers to avoid boilerplate persistence code.
 * We dont have to provide sql code . jpa abstracts it all
 */
