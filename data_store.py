class DataStore:
    def __init__(self):
        self.data = []

    def add_record(self, value):
        self.data.append(value)

    def get_all(self):
        return list(self.data)
