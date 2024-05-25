package application;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ma.projet.connexion.connexion;

public class EtudiantM {
    private Connection cn = connexion.getCn();

    public boolean create(Etudiant etudiant) {
        String query = "INSERT INTO Etudiant (nom, prenom, sexe, filiere) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setString(3, etudiant.getSexe());
            ps.setString(4, etudiant.getFiliere());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Etudiant etudiant) {
        String query = "DELETE FROM Etudiant WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, etudiant.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Etudiant etudiant) {
        String query = "UPDATE Etudiant SET nom = ?, prenom = ?, sexe = ?, filiere = ? WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setString(3, etudiant.getSexe());
            ps.setString(4, etudiant.getFiliere());
            ps.setInt(5, etudiant.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Etudiant findById(int id) {
        String query = "SELECT * FROM Etudiant WHERE id = ?";
        try (PreparedStatement ps = cn.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Etudiant(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("sexe"),
                    rs.getString("filiere")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        String query = "SELECT * FROM Etudiant";
        try (Statement st = cn.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                etudiants.add(new Etudiant(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("sexe"),
                    rs.getString("filiere")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etudiants;
    }
}
