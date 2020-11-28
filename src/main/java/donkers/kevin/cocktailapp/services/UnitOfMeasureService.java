package donkers.kevin.cocktailapp.services;

import donkers.kevin.cocktailapp.commands.UnitOfMeasureCommand;

import java.util.Set;

public interface UnitOfMeasureService {

    public Set<UnitOfMeasureCommand> listAllUoms();
}
