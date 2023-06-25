package cinema.dao.impl;

import cinema.dao.AbstractDao;
import cinema.dao.RoleDao;
import cinema.exception.DataProcessingException;
import cinema.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Role add(Role role) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
            return role;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't add role " + role, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Role> getByName(String roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> roleByName = session.createQuery("FROM "
                    + "Role r WHERE r.roleName = :roleName", Role.class);
            roleByName.setParameter("roleName", Role.RoleName.valueOf(roleName));
            return Optional.ofNullable(roleByName.getSingleResult());
        } catch (Exception e) {
            throw new DataProcessingException("Can't get role by roleName " + roleName, e);
        }
    }
}
