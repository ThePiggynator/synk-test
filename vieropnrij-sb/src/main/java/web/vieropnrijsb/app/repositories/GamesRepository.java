package web.vieropnrijsb.app.repositories;

import web.vieropnrijsb.app.models.Game;

import java.util.List;

public interface GamesRepository {
    List<Game> findAll();
}
