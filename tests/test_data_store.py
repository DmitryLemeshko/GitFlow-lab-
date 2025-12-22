from data_store import DataStore

def test_add_record():
    ds = DataStore()
    ds.add_record("X")
    assert ds.get_all() == ["X"]

def test_get_all_is_copy():
    ds = DataStore()
    ds.add_record(123)
    out = ds.get_all()
    out.append(999)
    assert ds.data == [123]
