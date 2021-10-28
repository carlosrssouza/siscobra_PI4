package br.ba.carlosrogerio.siscobrapi4.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ba.carlosrogerio.siscobrapi4.model.Pessoa;
import br.ba.carlosrogerio.siscobrapi4.util.HibernateUtil;

public class PessoaDao {

     /**
     * Grava pessoa
     * @param pessoa
     */    
    public void savePeople(Pessoa pessoa) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(pessoa);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Atualiza pessoa
     * @param pessoa
     */
    public void updatePeople(Pessoa pessoa) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(pessoa);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Remover pessoa
     * @param id_pessoa
     */
    public void deletePeople(int id_pessoa) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Pessoa pessoa = session.get(Pessoa.class, id_pessoa);
            if (pessoa != null) {
                session.delete(pessoa);
                System.out.println("pessoa foi excluida");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

     /**
     * Pega pessoa por id_pessoa
     * @param id_pessoa
     * @return
     */    
    public Pessoa getPeople(int id_pessoa) {

        Transaction transaction = null;
        Pessoa pessoa = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            pessoa = session.get(Pessoa.class, id_pessoa);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return pessoa;
    }

    /**
     * Todas as pessoas
     * @return
     */
    @SuppressWarnings("não verificado")
    public List < Pessoa > getAllPeople() {

        Transaction transaction = null;
        List < Pessoa > listOfPeople = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            listOfPeople = session.createQuery("FROM Pessoa").getResultList();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfPeople;
    }
}
