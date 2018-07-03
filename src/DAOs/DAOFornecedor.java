package DAOs;

import Entidades.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOFornecedor extends DAOGenerico<Fornecedor> {

    public DAOFornecedor() {
        super(Fornecedor.class);
    }

    public int autoIdFornecedor() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idFornecedor) FROM Fornecedor e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Fornecedor> listByIdFornecedor(int idFornecedor) {
        return em.createQuery("SELECT e FROM Fornecedor e WHERE e.idFornecedor = :idFornecedor").setParameter("idFornecedor", idFornecedor).getResultList();
    }

    public List<Fornecedor> listByNomeFornecedor(String nomeFornecedor) {
        return em.createQuery("SELECT e FROM Fornecedor e WHERE e.nomeFornecedor LIKE :nomeFornecedor").setParameter("nomeFornecedor", "%" + nomeFornecedor + "%").getResultList();
    }

    public List<Fornecedor> listInOrderIdFornecedor() {
        return em.createQuery("SELECT e FROM Fornecedor e ORDER BY e.idFornecedor").getResultList();
    }

    public List<Fornecedor> listInOrderNomeFornecedor() {
        return em.createQuery("SELECT e FROM Fornecedor e ORDER BY e.nomeFornecedor").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Fornecedor> lf;
        if (qualOrdem.equals("idFornecedor")) {
            lf = listInOrderIdFornecedor();
        } else {
            lf = listInOrderNomeFornecedor();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdFornecedor() + ";" + lf.get(i).getNomeFornecedor() + ";" + lf.get(i).getContatoFornecedor() + ";");
        }
        return ls;
    }
}

