package br.ba.carlosrogerio.siscobrapi4.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ba.carlosrogerio.siscobrapi4.model.Usuario;
import br.ba.carlosrogerio.siscobrapi4.util.HibernateUtil;

public class UsuarioDao {

     /**
     * Grava usuario
     * @param usuario
     */    
    public void saveUser(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(usuario);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Atualiza usuario
     * @param usuario
     */
    public void updateUser(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(usuario);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Remover usuario
     * @param login
     */
    public void deleteUser(String login) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Usuario usuario = session.get(Usuario.class, login);
            if (usuario != null) {
                session.delete(usuario);
                System.out.println("usuario deletado");
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
     * Pega usuario por login
     * @param login
     * @return
     **/    
    public Usuario getUser(String login) {

        Transaction transaction = null;
        Usuario usuario = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            usuario = session.get(Usuario.class, login);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return usuario;
    }

    /**
     * Todos usuarios
     * @return
     **/
    @SuppressWarnings("não verificado")
    public List < Usuario > getAllUser() {

        Transaction transaction = null;
        List < Usuario > listOfUser = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            listOfUser = session.createQuery("FROM Usuario").getResultList();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfUser;
    }
}
