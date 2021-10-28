package br.ba.carlosrogerio.siscobrapi4.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.ba.carlosrogerio.siscobrapi4.model.Divida;
import br.ba.carlosrogerio.siscobrapi4.util.HibernateUtil;

public class DividaDao {

     /**
     * Grava divida
     * @param divida
     */    
    public void saveDebt(Divida divida) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(divida);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Atualiza divida
     * @param divida
     */
    public void updateDebt(Divida divida) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(divida);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Remover divida
     * @param id_divida
     */
    public void deleteDebt(int id_divida) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Divida divida = session.get(Divida.class, id_divida);
            if (divida != null) {
                session.delete(divida);
                System.out.println("dívida foi excluída");
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
     * Pega divida por id_divida
     * @param id_divida
     * @return
     */    
    public Divida getDebt(int id_divida) {

        Transaction transaction = null;
        Divida divida = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            divida = session.get(Divida.class, id_divida);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return divida;
    }

    /**
     * Todas as dividas
     * @return
     */
    @SuppressWarnings("não verificado")
    public List < Divida > getAllDebt() {

        Transaction transaction = null;
        List < Divida > listOfDebt = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            listOfDebt = session.createQuery("FROM Divida").getResultList();
            
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfDebt;
    }
}
