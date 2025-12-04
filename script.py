from script import hello

def test_hello():
    # цей тест завжди зелений
    assert hello() is None

def test_fail():
    # цей тест завжди червоний для демонстрації
    assert 1 == 2
