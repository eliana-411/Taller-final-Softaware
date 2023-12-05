package edu.Software.model;

import java.util.List;

public interface IBanda {
  List<Artista> getMiembros();

  void setMiembros(List<Artista> miembros);
}
