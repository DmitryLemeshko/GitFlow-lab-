from script import process_message
from unittest.mock import Mock

def test_process_message_with_mock():
    store = Mock()
    result = process_message("  Hello  ", store)

    store.add_record.assert_called_with("hello")
    assert result == "Processed: hello"
