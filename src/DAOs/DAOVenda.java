package DAOs;

import Entidades.Venda;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOVenda extends DAOGenerico<Venda> {

    public DAOVenda() {
        super(Venda.class);
    }

    public int autoIdVenda() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idVenda) FROM Venda e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Venda> listByIdVenda(int idVenda) {
        return em.createQuery("SELECT e FROM Venda e WHERE e.idVenda = :idVenda").setParameter("idVenda", idVenda).getResultList();
    }

    public List<Venda> listByData(String data) {
        return em.createQuery("SELECT e FROM Venda e WHERE e.data LIKE :data").setParameter("data", "%" + data + "%").getResultList();
    }

    public List<Venda> listInOrderIdVenda() {
        return em.createQuery("SELECT e FROM Venda e ORDER BY e.idVenda").getResultList();
    }

    public List<Venda> listInOrderData() {
        return em.createQuery("SELECT e FROM Venda e ORDER BY e.data").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Venda> lf;
        if (qualOrdem.equals("idVenda")) {
            lf = listInOrderIdVenda();
        } else {
            lf = listInOrderData();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdVenda() + ";" + sdf.format(lf.get(i).getData()) + ";");
        }
        return ls;
    }
}

