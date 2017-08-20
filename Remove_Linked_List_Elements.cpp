#include <iostream>
#include "List.h"

using namespace std;
ListNode* removeElements(ListNode* head, int val);

void main() {
	ListNode* head = NULL;

	//push(&head, 7);
	//1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6
	push(&head, 6);
	push(&head, 5);
	push(&head, 4);
	push(&head, 3);
	push(&head, 6);
	push(&head, 2);
	push(&head, 1);
	removeElements(head, 6);
}

ListNode* removeElements(ListNode* head, int val) {
	if (head == NULL) {
		return NULL;
	}
	ListNode* temp = head;
	ListNode * prev = new ListNode(-1);
	prev->next = head;
	ListNode* headRef = prev;

	while (temp != NULL) {
		if (temp->val == val) {
			prev->next = temp->next;
			temp = prev->next;
			//delete temp;
		}
		else {
			prev = temp;
			temp = temp->next;
		}
	}
	return headRef->next;
}