import { PizzaStatus } from './pizza-status';
import { Message } from './message';

export interface Pizza {
    id: number;
    description: string;
    ingredient: string;
    name: string;
    status: PizzaStatus;
    createdAt: Date;
    modifiedAt: Date;
    messages: Message[];
}
