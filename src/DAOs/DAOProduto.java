package DAOs;

import Entidades.Produto;
import java.util.ArrayList;
import java.util.List;
import static DAOs.DAOGenerico.em;
import java.text.SimpleDateFormat;

public class DAOProduto extends DAOGenerico<Produto> {

    public DAOProduto() {
        super(Produto.class);
    }

    public int autoIdProduto() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idProduto) FROM Produto e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Produto> listByIdProduto(int idProduto) {
        return em.createQuery("SELECT e FROM Produto e WHERE e.idProduto = :idProduto").setParameter("idProduto", idProduto).getResultList();
    }

    public List<Produto> listByNomeProduto(String nomeProduto) {
        return em.createQuery("SELECT e FROM Produto e WHERE e.nomeProduto LIKE :nomeProduto").setParameter("nomeProduto", "%" + nomeProduto + "%").getResultList();
    }

    public List<Produto> listInOrderIdProduto() {
        return em.createQuery("SELECT e FROM Produto e ORDER BY e.idProduto").getResultList();
    }

    public List<Produto> listInOrderNomeProduto() {
        return em.createQuery("SELECT e FROM Produto e ORDER BY e.nomeProduto").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Produto> lf;
        if (qualOrdem.equals("idProduto")) {
            lf = listInOrderIdProduto();
        } else {
            lf = listInOrderNomeProduto();
        }

        List<String> ls = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdProduto() + ";" + lf.get(i).getNomeProduto() + ";" + lf.get(i).getQuantidadeProduto() + ";" + lf.get(i).getPrecoProduto() + ";" + lf.get(i).getMarcaIdMarca() + ";");
        }
        return ls;
    }
}

