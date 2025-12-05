from logic import process_user

def test_process_user_valid():
    loader = lambda p: {"name": "Dmytro"}
    result = process_user(loader, "any.json")
    assert result == "DMYTRO"

def test_process_user_empty():
    loader = lambda p: {"name": "  "}
    result = process_user(loader, "file.json")
    assert result == "UNKNOWN USER"
