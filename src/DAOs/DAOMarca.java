package DAOs;

import Entidades.Marca;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOMarca extends DAOGenerico<Marca> {

    public DAOMarca() {
        super(Marca.class);
    }

    public int autoIdMarca() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idMarca) FROM Marca e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Marca> listByIdMarca(int idMarca) {
        return em.createQuery("SELECT e FROM Marca e WHERE e.idMarca = :idMarca").setParameter("idMarca", idMarca).getResultList();
    }

    public List<Marca> listByNomeMarca(String nomeMarca) {
        return em.createQuery("SELECT e FROM Marca e WHERE e.nomeMarca LIKE :nomeMarca").setParameter("nomeMarca", "%" + nomeMarca + "%").getResultList();
    }

    public List<Marca> listInOrderIdMarca() {
        return em.createQuery("SELECT e FROM Marca e ORDER BY e.idMarca").getResultList();
    }

    public List<Marca> listInOrderNomeMarca() {
        return em.createQuery("SELECT e FROM Marca e ORDER BY e.nomeMarca").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Marca> lf;
        if (qualOrdem.equals("idMarca")) {
            lf = listInOrderIdMarca();
        } else {
            lf = listInOrderNomeMarca();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdMarca() + ";" + lf.get(i).getNomeMarca() + ";");
        }
        return ls;
    }
}

