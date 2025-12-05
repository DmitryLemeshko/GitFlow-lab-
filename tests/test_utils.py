from utils import add, normalize_text

def test_add():
    assert add(2, 3) == 5

def test_normalize_text():
    assert normalize_text("  HeLLo ") == "hello"
