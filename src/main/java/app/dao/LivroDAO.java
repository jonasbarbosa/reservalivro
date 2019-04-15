package app.dao;

import app.entity.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.domain.*;
import org.springframework.data.repository.query.*;
import org.springframework.transaction.annotation.*; 


/**
 * Realiza operação de Create, Read, Update e Delete no banco de dados.
 * Os métodos de create, edit, delete e outros estão abstraídos no JpaRepository
 * 
 * @see org.springframework.data.jpa.repository.JpaRepository
 * 
 * @generated
 */
@Repository("LivroDAO")
@Transactional(transactionManager="app-TransactionManager")
public interface LivroDAO extends JpaRepository<Livro, java.lang.String> {

  /**
   * Obtém a instância de Livro utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Instância relacionada com o filtro indicado
   * @generated
   */    
  @Query("SELECT entity FROM Livro entity WHERE entity.id = :id")
  public Livro findOne(@Param(value="id") java.lang.String id);

  /**
   * Remove a instância de Livro utilizando os identificadores
   * 
   * @param id
   *          Identificador 
   * @return Quantidade de modificações efetuadas
   * @generated
   */    
  @Modifying
  @Query("DELETE FROM Livro entity WHERE entity.id = :id")
  public void delete(@Param(value="id") java.lang.String id);


      
  /**
   * OneToMany Relation - Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Reserva entity WHERE entity.livro.id = :id AND (:search = :search)")
  public Page<Reserva> findReservaGeneralSearch(@Param(value="search") java.lang.String search, @Param(value="id") java.lang.String id, Pageable pageable);

  /** 
   * OneToMany Relation - Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Reserva entity WHERE entity.livro.id = :id AND (:dataReserva is null OR entity.dataReserva = :dataReserva) AND (:dataEmprestimo is null OR entity.dataEmprestimo = :dataEmprestimo)")
  public Page<Reserva> findReservaSpecificSearch(@Param(value="id") java.lang.String id, @Param(value="dataReserva") java.util.Date dataReserva, @Param(value="dataEmprestimo") java.util.Date dataEmprestimo, Pageable pageable);

  /**
   * OneToMany Relation
   * @generated
   */
  @Query("SELECT entity FROM Reserva entity WHERE entity.livro.id = :id")
  public Page<Reserva> findReserva(@Param(value="id") java.lang.String id, Pageable pageable);
  /**
   * ManyToOne Relation
   * @generated
   */
  @Query("SELECT entity.user FROM Reserva entity WHERE entity.livro.id = :id")
  public Page<User> listUser(@Param(value="id") java.lang.String id, Pageable pageable);

  /**
   * ManyToOne Relation Delete
   * @generated
   */
  @Modifying
  @Query("DELETE FROM Reserva entity WHERE entity.livro.id = :instanceId AND entity.user.id = :relationId")
  public int deleteUser(@Param(value="instanceId") java.lang.String instanceId, @Param(value="relationId") java.lang.String relationId);

  
  /**
   * Searchable fields - General search (Only strings fields)
   * @generated
   */
  @Query("SELECT entity FROM Livro entity WHERE entity.nome like concat('%',coalesce(:search,''),'%') OR entity.autor like concat('%',coalesce(:search,''),'%') OR entity.isbn like concat('%',coalesce(:search,''),'%')")
  public Page<Livro> generalSearch(@Param(value="search") java.lang.String search, Pageable pageable);

  /**
   * Searchable fields - Specific search
   * @generated
   */
  @Query("SELECT entity FROM Livro entity WHERE (:nome is null OR entity.nome like concat('%',:nome,'%')) AND (:autor is null OR entity.autor like concat('%',:autor,'%')) AND (:isbn is null OR entity.isbn like concat('%',:isbn,'%'))")
  public Page<Livro> specificSearch(@Param(value="nome") java.lang.String nome, @Param(value="autor") java.lang.String autor, @Param(value="isbn") java.lang.String isbn, Pageable pageable);
  
}
