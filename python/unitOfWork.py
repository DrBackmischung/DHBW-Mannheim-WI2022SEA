class Entity:
    def __init__(self, id, name):
        self.id = id
        self.name = name


class UnitOfWork:
    def __init__(self):
        self.new_entities = []
        self.updated_entities = []
        self.deleted_entities = []

    def register_new(self, entity):
        self.new_entities.append(entity)

    def register_updated(self, entity):
        self.updated_entities.append(entity)

    def register_deleted(self, entity):
        self.deleted_entities.append(entity)

    def commit(self):
        # Logic to persist changes to the data store
        for entity in self.new_entities:
            print(f"Creating entity: {entity.name}")

        for entity in self.updated_entities:
            print(f"Updating entity: {entity.name}")

        for entity in self.deleted_entities:
            print(f"Deleting entity: {entity.name}")

        # Clear the lists after committing
        self.new_entities.clear()
        self.updated_entities.clear()
        self.deleted_entities.clear()


# Example usage
if __name__ == "__main__":
    uow = UnitOfWork()

    # Creating entities
    entity1 = Entity(1, "Entity 1")
    entity2 = Entity(2, "Entity 2")
    uow.register_new(entity1)
    uow.register_new(entity2)

    # Updating an entity
    entity3 = Entity(3, "Entity 3")
    uow.register_updated(entity3)

    # Deleting an entity
    entity4 = Entity(4, "Entity 4")
    uow.register_deleted(entity4)

    # Committing changes
    uow.commit()
